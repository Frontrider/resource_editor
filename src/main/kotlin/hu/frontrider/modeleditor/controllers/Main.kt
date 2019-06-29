package hu.frontrider.modeleditor.controllers

import hu.frontrider.modeleditor.resources.ResourcePackManager
import javafx.event.ActionEvent
import javafx.stage.DirectoryChooser
import javafx.stage.FileChooser


interface Main :Controller,FieldGetter{

    fun openNew(actionEvent: ActionEvent) {
        val fileChooser = FileChooser()
        fileChooser.selectedExtensionFilter = FileChooser.ExtensionFilter("zip files", "zip")
        val file = fileChooser.showOpenDialog(getWindow(actionEvent))

        ResourcePackManager().loadResourcePackFromZip(file.absolutePath)
    }

    fun openNewDir(actionEvent: ActionEvent) {
        val fileChooser = DirectoryChooser()
        val directory = fileChooser.showDialog(getWindow(actionEvent))
        ResourcePackManager().loadFolder(directory.absolutePath)
    }

    fun closeCurrent(actionEvent: ActionEvent) {

    }


}