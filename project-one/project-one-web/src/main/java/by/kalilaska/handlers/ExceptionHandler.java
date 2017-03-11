package by.kalilaska.handlers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import by.kalilaska.loggers.LoggerMaster;

public class ExceptionHandler implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		System.out.println("Spring MVC ExceptionHandler handling");
		LoggerMaster.setupClass(this.getClass());
		LoggerMaster.error("ErrorLog: " + ex);

		return new ModelAndView("exception", "exceptionMsg", "ExceptionHandler msg: " + ex.toString());
	}

}
