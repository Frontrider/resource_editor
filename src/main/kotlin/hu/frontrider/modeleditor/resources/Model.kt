package hu.frontrider.modeleditor.resources


data class Model(
    var textures: Map<String,String> = HashMap(),
    var elements:List<Element> = emptyList()
){
    fun getMesh():FloatArray{
        val vertices = ArrayList<Float>()

        for (element in elements) {
            val x1 = element.from[0].toFloat()
            val y1 = element.from[1].toFloat()
            val z1 = element.from[2].toFloat()

            val x2 = element.to[0].toFloat()
            val y2 = element.to[1].toFloat()
            val z2 = element.to[2].toFloat()

            vertices.addAll(arrayOf(x1,y2,z2))
        }

        return floatArrayOf(*vertices.toFloatArray())

    }

    fun getTexture():FloatArray{
        return floatArrayOf()
    }

    fun getFaces():IntArray{
        return intArrayOf()
    }
}

data class Element(
    var from: IntArray = intArrayOf(0,0,0),
    var to: IntArray = intArrayOf(0,0,0),
    var faces:Faces = Faces(null,null,null,null,null,null)

) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Element

        if (!from.contentEquals(other.from)) return false
        if (!to.contentEquals(other.to)) return false
        if (faces != other.faces) return false

        return true
    }

    override fun hashCode(): Int {
        var result = from.contentHashCode()
        result = 31 * result + to.contentHashCode()
        result = 31 * result + faces.hashCode()
        return result
    }
}

data class Faces(

    var up:Face?,
    var down:Face?,
    var north:Face?,
    var south:Face?,
    var east:Face?,
    var west:Face?

)


data class Face(
    var uv:IntArray?,
    val texture:String? ="",
    var cullFace: Direction?

) {


    override fun hashCode(): Int {
        var result = uv?.contentHashCode() ?: 0
        result = 31 * result + (texture?.hashCode() ?: 0)
        result = 31 * result + (cullFace?.hashCode() ?: 0)
        return result
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Face

        if (uv != null) {
            if (other.uv == null) return false
            if (!uv!!.contentEquals(other.uv!!)) return false
        } else if (other.uv != null) return false
        if (texture != other.texture) return false
        if (cullFace != other.cullFace) return false

        return true
    }
}

enum class Direction{
    UP,DOWN,EAST,WEST,NORTH,SOUTH;

    override fun toString():String{
        return this.name.toLowerCase()
    }
}