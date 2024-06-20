package gui

import scalafx.application.JFXApp3
import scalafx.application.Platform
import scalafx.application.JFXApp3.PrimaryStage
import scalafx.scene.Scene
import scalafx.scene.control.Button
import scalafx.scene.layout.StackPane
import scalafx.Includes._

object SimpleFxGUI extends JFXApp3:
  override def start(): Unit =
    stage = new PrimaryStage:
      title = "Simple ScalaFX GUI"
      scene = new Scene(300, 200):
        root = new StackPane:
          children = Seq(
            new Button:
              text = "Click me"
              onAction = _ =>
                println("Hello, ScalaFX!")
          )
        onCloseRequest = _ =>
          Platform.exit()
