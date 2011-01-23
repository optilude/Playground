package controllers.admin;

import play.mvc.With;

import com.deloitte.timesink.domain.Context;

import controllers.CRUD;
import controllers.Check;
import controllers.Secure;

@CRUD.For(Context.class)
@With(Secure.class)
@Check("admin")
public class ManageContexts extends CRUD {
}
