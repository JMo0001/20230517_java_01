package kh.lclass.db1.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class AdviceLog {
	private static final Logger logger = LoggerFactory.getLogger(AdviceLog.class);

//	@Pointcut("execution(타겟메소드)")
//	.. 매개변수 없거나 여러개 있거나..
//	* 1개 이상일 때 씀.
	@Pointcut("execution(public * kh.lclass.db1..*Dao.*(..))")
	public void daoPointCut() {}
	@Pointcut("execution(public * kh.lclass.db1..*Service.*(..))")
	public void servicePointCut() {}
	@Pointcut("execution(public * kh.lclass.db1..*Controller.*(..))")
	public void controllerPointCut() {}

//	@Before("daoPointCut()")
//	public void beforeDaoLog(JoinPoint jp) {
//		//공통 코드
//		logger.debug("["+jp.getThis()+":"+jp.getSignature().getName()+"]");
//		
//		//타겟메소드로 전달되는 매개인자들
//		Object[] args = jp.getArgs();
//		for(int i=0; i<args.length; i++) {
//			logger.debug("--args["+i+"]"+args[i]+"");
//		}
//	}
//	@AfterReturning(pointcut = "daoPointCut()", returning = "returnObj")
//	public Object afterDaoLog(JoinPoint jp, Object returnObj) {
//		//공통 코드
//		logger.debug("["+jp.getThis()+":"+jp.getSignature().getName()+"]");
//		
//		//타겟메소드로 전달되는 매개인자들
//		Object[] args = jp.getArgs();
//		for(int i=0; i<args.length; i++) {
//			logger.debug("--args["+i+"]"+args[i]+"");
//		}
//		
//		logger.debug("[returnObj: "+ returnObj);
//		return returnObj;
//	}
	
	@Around("daoPointCut()")
	public Object arroundDaoLog(ProceedingJoinPoint pjp) throws Throwable {
		logger.debug("▷▷["+pjp.getThis()+":"+pjp.getSignature().getName()+"]");
		
		//타겟메소드로 전달되는 매개인자들
		Object[] args = pjp.getArgs();
		for(int i=0; i<args.length; i++) {
			logger.debug("▷▷--args["+i+"]"+args[i]+"");
		}
		
		Object robj = null;	// 타겟메소드로부터 return 값을 받아 저장할 공간.
		StopWatch stopwatch = new StopWatch();
		stopwatch.start();
		robj = pjp.proceed();	//	타겟메소드 실행
		stopwatch.stop();
		logger.debug("▷▷▷[Dao ▷]"+stopwatch.getTotalTimeMillis()+"ms");
		return robj;	//	타겟메소드를 호출한 메소드에 return함.
	}
	
	@Around("servicePointCut()")
	public Object arroundSrvLog(ProceedingJoinPoint pjp) throws Throwable{
		Object robj = null;	// 타겟메소드로부터 return 값을 받아 저장할 공간.
		
		logger.debug("▷▷["+pjp.getThis()+":"+pjp.getSignature().getName()+"]");
		//타겟메소드로 전달되는 매개인자들
		Object[] args = pjp.getArgs();
		for(int i=0; i<args.length; i++) {
			logger.debug("▷▷--args["+i+"]"+args[i]+"");
		}
		StopWatch stopwatch = new StopWatch();
		stopwatch.start();
		robj = pjp.proceed();
		stopwatch.stop();
		logger.debug("▷▷[Srv ▷]"+stopwatch.getTotalTimeMillis());
		return robj;	//	타겟메소드를 호출한 메소드에 return함.
	}
	@Around("controllerPointCut()")
	public Object arroundCtrLog(ProceedingJoinPoint pjp) throws Throwable{
		Object robj = null;	// 타겟메소드로부터 return 값을 받아 저장할 공간.
		
		logger.debug("▷▷["+pjp.getThis()+":"+pjp.getSignature().getName()+"]");
		//타겟메소드로 전달되는 매개인자들
		Object[] args = pjp.getArgs();
		for(int i=0; i<args.length; i++) {
			logger.debug("▷▷--args["+i+"]"+args[i]+"");
		}
		StopWatch stopwatch = new StopWatch();
		stopwatch.start();
		robj = pjp.proceed();
		stopwatch.stop();
		logger.debug("▷▷[Ctr ▷]"+stopwatch.getTotalTimeMillis()+"ms");
		return robj;	//	타겟메소드를 호출한 메소드에 return함.
		
	}
	
}
