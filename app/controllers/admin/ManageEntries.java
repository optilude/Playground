package controllers.admin;

import play.mvc.With;

import com.deloitte.timesink.domain.Entry;

import controllers.CRUD;
import controllers.Check;
import controllers.Secure;

@CRUD.For(Entry.class)
@With(Secure.class)
@Check("admin")
public class ManageEntries extends CRUD {

}
