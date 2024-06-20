package gui

import scala.swing._
import scala.swing.event.ButtonClicked

object SimpleSwingGUI extends SimpleSwingApplication:
  def top: Frame = new MainFrame:
    title = "Simple Scala Swing GUI"
    contents = new BoxPanel(Orientation.Vertical):
      contents += new Button:
        text = "Click me"
          reactions += {
            case ButtonClicked(_) =>
              println("Hello, Scala Swing!")
          }
    centerOnScreen()
    visible = true
    pack()