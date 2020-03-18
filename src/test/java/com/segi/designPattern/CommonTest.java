package com.segi.designPattern;

import com.segi.designPattern.action.memo.CareTaker;
import com.segi.designPattern.action.memo.Memento;
import com.segi.designPattern.action.memo.Originator;
import com.segi.designPattern.action.observer.demo1.BinObserver;
import com.segi.designPattern.action.observer.demo1.HexObserver;
import com.segi.designPattern.action.observer.demo1.OctalObserver;
import com.segi.designPattern.action.observer.demo1.Subject;
import com.segi.designPattern.action.observer.demo2.Listener1;
import com.segi.designPattern.action.observer.demo2.Listener2;
import com.segi.designPattern.action.observer.demo2.Publisher;
import com.segi.designPattern.action.strategy.demo1.Context;
import com.segi.designPattern.action.strategy.demo1.StrategyOperationAdd;
import com.segi.designPattern.action.strategy.demo1.StrategyOperationMul;
import com.segi.designPattern.action.strategy.demo1.StrategyOperationSub;
import com.segi.designPattern.action.strategy.demo2.WarnByPeriod;
import com.segi.designPattern.action.strategy.demo2.WarnEveryDay;
import com.segi.designPattern.action.strategy.demo2.WarnService;
import com.segi.designPattern.action.template.demo1.FootBall;
import com.segi.designPattern.action.template.demo1.PingPong;
import com.segi.designPattern.create.factory.demo1.Shape;
import com.segi.designPattern.create.factory.demo1.ShapeFactory;
import com.segi.designPattern.create.prototype.demo1.ShapeCached;
import com.segi.designPattern.create.singleton.doublelock.DoubleLockSingleton;
import com.segi.designPattern.create.singleton.enums.EnumSingleton;
import com.segi.designPattern.create.singleton.hangury.HangurySingleton;
import com.segi.designPattern.create.singleton.lazy.LazySecureSingleton;
import com.segi.designPattern.create.singleton.lazy.LazySingleton;
import com.segi.designPattern.create.singleton.staticclass.StaticClassSingleton;
import com.segi.designPattern.struct.adapter.demo1.AudioPlayer;
import com.segi.designPattern.struct.adapter.demo2.CommonVideoPlayer;
import com.segi.designPattern.struct.adapter.demo2.VideoPlayer;
import com.segi.designPattern.struct.decorator.CircleShape;
import com.segi.designPattern.struct.decorator.RectShape;
import com.segi.designPattern.struct.decorator.RedShapeDecorator;
import com.segi.designPattern.struct.facade.demo1.ShapeMaker;
import org.junit.Test;

/**
 * @author chenzx
 * @date 2018-11-23 下午 7:59
 */
public class CommonTest {

    /**
     * 观察者模式（行为型）
     */
    @Test
    public void testObserver() {
        Subject subject = new Subject();
        new BinObserver(subject);
        new OctalObserver(subject);
        new HexObserver(subject);
        System.out.println("input 10");
        subject.setState(10);
        System.out.println("input 15");
        subject.setState(15);
    }

    @Test
    public void testObserver2() {
        final Publisher publisher = new Publisher();
        new Listener1(publisher);
        new Listener2(publisher);
        publisher.setEvent("hello");
        publisher.setEvent("world");
    }

    /**
     * 策略模式（行为型）
     */
    @Test
    public void testStrategy() {
        System.out.println(new Context(new StrategyOperationAdd()).executeOperation(1, 2));
        System.out.println(new Context(new StrategyOperationSub()).executeOperation(1, 2));
        System.out.println(new Context(new StrategyOperationMul()).executeOperation(1, 2));
    }

    @Test
    public void testStrategy2() {
        new WarnService(new WarnByPeriod()).doWarnTask();
        new WarnService(new WarnEveryDay()).doWarnTask();
    }

    /**
     * 适配器模式（结构型）
     */
    @Test
    public void testAdapter1() {
        AudioPlayer audioPlayer = new AudioPlayer();
        audioPlayer.play("mp3", "mp3.file");
        audioPlayer.play("lvc", "lvc.file");
        audioPlayer.play("mp4", "mp4.file");
        audioPlayer.play("mp5", "mp5.file");
    }

    /**
     * 适配器模式+策略模式（自定义）
     */
    @Test
    public void testAdapter() {
        VideoPlayer videoPlayer = new CommonVideoPlayer();
        videoPlayer.play("common", "commmonVideo");
        videoPlayer.play("mp4", "mp4Video");
        videoPlayer.play("wma", "wmaVideo");
        videoPlayer.play("mp5", "mp5Video");
    }

    /**
     * 原型模式
     * @throws CloneNotSupportedException
     */
    @Test
    public void testPropotype() throws CloneNotSupportedException {
        ShapeCached shapeCached = new ShapeCached();
        shapeCached.loadShapes();
        System.out.println(shapeCached.getShape("1"));
        System.out.println(shapeCached.getShape("2"));
        System.out.println(shapeCached.getShape("3"));
        System.out.println(shapeCached.getShape("1"));
        System.out.println(shapeCached.getShape("2"));
        System.out.println(shapeCached.getShape("3"));
    }

    /**
     * 工厂模式（创建型）
     * @return
     */
    @Test
    public void testFactory() {
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape circle = shapeFactory.getShape("Circle");
        Shape rectangle = shapeFactory.getShape("Rectangle");
        Shape square = shapeFactory.getShape("Square");
        circle.draw();
        rectangle.draw();
        square.draw();
    }

    /**
     * 单例模式（懒汉式不安全，懒汉式安全，饿汉式，双重校验锁，登录式，枚举）（创建型）
     */
    @Test
    public void testSingleton() {
        HangurySingleton hangurySingleton1 = HangurySingleton.getInstatnce();
        HangurySingleton hangurySingleton2 = HangurySingleton.getInstatnce();
        System.out.println(hangurySingleton1 == hangurySingleton2);

        LazySingleton lazySingleton1 = LazySingleton.getInstatnce();
        LazySingleton lazySingleton2 = LazySingleton.getInstatnce();
        System.out.println(lazySingleton1 == lazySingleton2);

        LazySecureSingleton lazySecureSingleton1 = LazySecureSingleton.getInstatnce();
        LazySecureSingleton lazySecureSingleton2 = LazySecureSingleton.getInstatnce();
        System.out.println(lazySecureSingleton1 == lazySecureSingleton2);

        DoubleLockSingleton doubleLockSingleton1 = DoubleLockSingleton.getInstatnce();
        DoubleLockSingleton doubleLockSingleton2 = DoubleLockSingleton.getInstatnce();
        System.out.println(doubleLockSingleton1 == doubleLockSingleton2);

        StaticClassSingleton staticClassSingleton1 = StaticClassSingleton.getInstance();
        StaticClassSingleton staticClassSingleton2 = StaticClassSingleton.getInstance();
        System.out.println(staticClassSingleton1 == staticClassSingleton2);

        EnumSingleton enumSingleton1 = EnumSingleton.ENUM_SINGLETON;
        EnumSingleton enumSingleton2 = EnumSingleton.ENUM_SINGLETON;
        System.out.println(enumSingleton1 == enumSingleton2);
    }

    /**
     * 模板模式（行为型）
     */
    @Test
    public void testTemplate() {
        PingPong pingPong = new PingPong();
        pingPong.play();
        FootBall footBall = new FootBall();
        footBall.play();
    }

    /**
     * 门面模式（外观模式）（结构型）
     */
    @Test
    public void testFacade() {
        ShapeMaker shapeMaker = new ShapeMaker();
        shapeMaker.drawCircle();
        shapeMaker.drawSquare();
        shapeMaker.drawRectangle();
    }

    /**
     * 装饰者模式（结构型）
     */
    @Test
    public void testDecorator() {
        com.segi.designPattern.struct.decorator.Shape circleShape = new CircleShape();
        com.segi.designPattern.struct.decorator.Shape rectShape = new RectShape();

        RedShapeDecorator redCircleDecorator = new RedShapeDecorator(circleShape);
        RedShapeDecorator redRectDecorator = new RedShapeDecorator(rectShape);
        circleShape.draw();
        redCircleDecorator.draw();
        redRectDecorator.draw();
    }

    /**
     * 备忘录模式（行为型）
     */
    @Test
    public void testMemo() {
        Originator originator = new Originator();
        CareTaker careTaker = new CareTaker();
        originator.setState("state-01");
        originator.setState("state-02");
        careTaker.add(originator.saveStateToMemento());
        originator.setState("state-03");
        careTaker.add(originator.saveStateToMemento());
        originator.setState("state-04");
        System.out.println(originator.getState());
        System.out.println(careTaker.get(0).getState());
        System.out.println(careTaker.get(1).getState());

    }
}
