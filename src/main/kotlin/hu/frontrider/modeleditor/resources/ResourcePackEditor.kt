package hu.frontrider.modeleditor.resources

import hu.frontrider.modeleditor.Editor
import hu.frontrider.modeleditor.Identifier
import javafx.fxml.FXMLLoader
import javafx.scene.Node
import javafx.scene.Parent
import java.util.*

class ResourcePackEditor(val manager: ResourcePackManager) : Editor {

    override fun getTypes(): Iterable<String> {
        return Editor.Types.values().map { it.toString() }.toList()
    }

    override fun getItems(type: String): Map<Identifier, String> {
        return manager.getFiles().filter {
            it.split("/")[2] == type
        }.groupBy {
            val list = it.split("/")

            Identifier(list[1], list.subList(3, list.size).joinToString(separator = "/").split(".")[0])
        }.mapValues {
            it.value[0]
        }
    }

    override fun display(type: String, identifier: Identifier): Optional<Node> {
        return when (Editor.Types.valueOf(type)) {
            Editor.Types.TEXTURE -> {
                val fxmlLoader = FXMLLoader(javaClass.getResource("/texture.fxml"));

                fxmlLoader.namespace.apply{
                    this[""] = ""
                }

                val parent = FXMLLoader.load<Node>(javaClass.getResource("/texture.fxml"))
                Optional.of(parent as Node)
            }
            Editor.Types.MODEL -> Optional.of(FXMLLoader.load<Node>(javaClass.getResource("/model.fxml")) as Node)
            else -> Optional.empty()
        }
    }
}