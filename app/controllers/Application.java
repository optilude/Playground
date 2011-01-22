package controllers;

import java.util.List;

import play.modules.spring.Spring;
import play.mvc.Controller;

import com.deloitte.timesink.domain.Context;
import com.deloitte.timesink.repository.ContextRepository;

public class Application extends Controller {

	protected static ContextRepository contextRepository = Spring.getBeanOfType(ContextRepository.class);
	
	public static void index() {
		List<Context> contexts = contextRepository.allContexts(); 
        render(contexts);
    }

}