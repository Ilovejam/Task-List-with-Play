package controllers

import javax.inject._
import shared.SharedMessages
import play.api.mvc._
import play.api.i18n._
import sun.security.util.Password


class TaskList1 @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  def login = Action{
    Ok(views.html.login1())
  }

  def validateLoginGet(username:String, password: String) = Action {
    Ok(s"User $username loged in with password: $password")
  }

  def validateLoginPost = Action { request  =>
    val postVals = request.body.asFormUrlEncoded
    postVals.map{ args =>
      val username = args("username").head
      val password = args("password").head
      Ok(s"User $username loged in with password: $password")
    }.getOrElse(Ok("Oops"))
  }

  def taskList = Action {
    val tasks = List("eat","sleep","code")
    Ok(views.html.taskList1(tasks))
  }

}