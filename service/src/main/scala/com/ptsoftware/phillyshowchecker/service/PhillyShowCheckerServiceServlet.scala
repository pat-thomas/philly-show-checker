package com.ptsoftware.phillyshowchecker.service

import org.scalatra._

class PhillyShowCheckerServiceServlet extends PhillyShowCheckerServiceStack {

  get("/") {
		"Hello world"
  }

	get("/ping") {
		"Pong!"
	}

	get("/hello/:name") {
		val name = params("name")
		name
	}
}
