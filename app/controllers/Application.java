package controllers;

import java.util.List;

import javax.inject.Inject;

import play.mvc.Controller;

import com.deloitte.timesink.domain.Context;
import com.deloitte.timesink.repository.ContextRepository;

public class Application extends Controller {

	@Inject
	protected static ContextRepository contextRepository;
	
	public static void index() {
		List<Context> contexts = contextRepository.allContexts(); 
        render(contexts);
    }

}