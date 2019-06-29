package hu.frontrider.modeleditor

import javafx.scene.Node
import java.util.*

interface Editor {

    enum class Types(val identifier:String){
        TEXTURE("textures"),MODEL("models"),BLOCKSTATE("blockstates"),LANGUAGE("lang");

        override fun toString(): String {
            return identifier
        }
    }
    /**
     * Get items for a specific data type.
     * */
    fun getItems(type: Types): Map<Identifier, String>{
        return getItems(type.toString())
    }
    fun getItems(type: String): Map<Identifier, String>

    fun display(type:Types,identifier: Identifier): Optional<Node>{
        return display(type.toString(),identifier)
    }

    fun display(type:String,identifier: Identifier): Optional<Node>

    fun getTypes():Iterable<String>
}