package gui

import scalafx.application.JFXApp3
import scalafx.application.Platform
import scalafx.application.JFXApp3.PrimaryStage
import scalafx.scene.Scene
import scalafx.scene.control.Button
import scalafx.scene.image.{Image, ImageView}
import scalafx.scene.layout.GridPane

object SimpleFxGUI extends JFXApp3:
  override def start(): Unit =
    val pngImage = new Image("/cards/backs/blue.png")
    val imageView = new ImageView(pngImage)
    imageView.onMouseClicked = _ => println("Image clicked!")

    val button = new Button:
      text = "Click me"
      onAction = _ => println("Hello, ScalaFX!")

    stage = new PrimaryStage:
      title = "Simple ScalaFX GUI"
      scene = new Scene():
        root = new GridPane():
          children = Seq(
            imageView,
            button
          )
          // Set constraints for ImageView
          GridPane.setConstraints(imageView, 0, 0)
          // Set constraints for Button
          GridPane.setConstraints(button, 1, 0)
        onCloseRequest = _ => Platform.exit()
      sizeToScene()
