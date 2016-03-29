package com.pt-software.philly-show-checker.service

import org.scalatra._

class PhillyShowCheckerServlet extends PhillyShowCheckerServiceStack {

  get("/") {
    <html>
      <body>
        <h1>Hello, world!</h1>
        Say <a href="hello-scalate">hello to Scalate</a>.
      </body>
    </html>
  }

}
