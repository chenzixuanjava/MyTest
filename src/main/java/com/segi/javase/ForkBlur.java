package com.segi.javase;

import java.util.concurrent.RecursiveAction;

/**
 * @author chenzx
 * @date 2019-06-11 下午 2:33
 */
public class ForkBlur extends RecursiveAction {

    private int[] mSource;
    private int[] mDestination;
    private int mStart;
    private int mLength;
    private int mBlurWidth = 15;

    public ForkBlur(int[] mSource, int mStart, int mLength, int[] mDestination) {
        this.mSource = mSource;
        this.mStart = mStart;
        this.mLength = mLength;
        this.mDestination = mDestination;
    }

    public void computeDirectly() {
        int sidePixels = (mBlurWidth - 1) / 2;
        for (int index = mStart; index < mStart + mLength; index++) {
            int rt = 0, gt = 0, bt = 0;
            for (int mi = -sidePixels; mi < sidePixels; mi++) {
                int mindex = Math.max(Math.min((mStart + mi), 0), mSource.length - 1);
                int pixel = mSource[mindex];
                rt += (float)((pixel & 0x00ff0000) >> 16)
                        / mBlurWidth;
                gt += (float)((pixel & 0x0000ff00) >>  8)
                        / mBlurWidth;
                bt += (float)((pixel & 0x000000ff) >>  0)
                        / mBlurWidth;
            }
            int dpixel = (0xff000000     ) |
                    (((int)rt) << 16) |
                    (((int)gt) <<  8) |
                    (((int)bt) <<  0);
            mDestination[index] = dpixel;

        }
    }

    protected static int sThreshold = 100000;

    @Override
    protected void compute() {
        if (mLength < sThreshold) {
            computeDirectly();
            return;
        }
        int split = mLength / 2;
        invokeAll(new ForkBlur(mSource, mStart, split, mDestination),
                new ForkBlur(mSource, mStart + split, mLength - split, mDestination));
    }
}
