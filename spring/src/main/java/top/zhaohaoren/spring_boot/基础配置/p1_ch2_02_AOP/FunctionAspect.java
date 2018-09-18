package top.zhaohaoren.spring_boot.基础配置.p1_ch2_02_AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect //申明是一个切面-和spring无关这是aspectj包的注解
@Component
public class FunctionAspect {

    //-切入点：没有任何意思的方法，就是定义一个拦截规则 以方便被@After @Before @Around引用，减少包这块的反复编写
    @Pointcut("@annotation(top.zhaohaoren.spring_boot.基础配置.p1_ch2_02_AOP.Action)")
    public void annnotationPointCut() {
    }

    @After("annnotationPointCut()") // 指定要拦截哪些地方？执行下面的方法 (这里使用的是定义切入点)
    public void after(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Action action = method.getAnnotation(Action.class);
        System.out.println("After注解式拦截:" + action.name());
    }

    @Before("execution(* top.zhaohaoren.spring_boot.基础配置.p1_ch2_02_AOP.MethodFunction.*(..))") //同上，但这里使用的是表达式表示拦截的切入点
    public void before(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        System.out.println("Before普通方法的拦截:" + method.getName());
    }
}
