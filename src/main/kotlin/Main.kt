package org.example

import com.fasterxml.jackson.annotation.JsonAlias
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement
import com.fasterxml.jackson.module.kotlin.KotlinModule
import kotlinx.serialization.Transient
import java.io.File
import java.io.Serializable
val divider = File.separator
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val missionpath = "C:\\Users\\mathi\\Desktop\\TP1\\Mission"
    val measurepath = "C:\\Users\\mathi\\Desktop\\TP1\\Mesures"
    val dossier = File("C:\\Users\\mathi\\Desktop\\TP1")
    val dossierpath ="C:\\Users\\mathi\\Desktop\\TP1"

    val mapper = XmlMapper()



    //val famille2 = Famille("Mathias2", 25, true, mutableListOf(Person("John", 25, false), Person("Jane", 25, false)))
   // saveToXml("famille4", famille2, dossierpath)
    val fichier = File(dossierpath + divider + "famille4.xml")
    val dxml = fichier.readText()
    val fmille = mapper.readValue(dxml, Famille::class.java)
   fmille.children.forEach { println(it.name) }



}

@JacksonXmlRootElement(localName = "person")
class Person (

    @field:JacksonXmlProperty(localName = "nom")
    var name: String = "John",
    @field:JacksonXmlProperty(localName = "age")
    var age: Int = 25,
    @field:JacksonXmlProperty(localName = "estmarrier")
    var isMarried: Boolean =false
): Serializable

@JacksonXmlRootElement(localName = "famille")
class Famille(
    @field:JsonIgnore
@field:JacksonXmlProperty(localName = "nom")
    var name: String ,

@field:JacksonXmlProperty(localName = "age")
    var age: Int = 25,
@field:JacksonXmlProperty(localName = "isMarried")
    var isMarried: Boolean = false,

@field:JacksonXmlElementWrapper(useWrapping = true, localName = "enfants")
@field:JacksonXmlProperty(localName = "person")
var children: MutableList<Person> = mutableListOf()
): Serializable

fun saveToXml(name: String, element : Any, path : String){

    val fichier = File(path + divider+ "$name.xml")
    val mapper = XmlMapper().apply {
        setDefaultUseWrapper(false)
        enable(SerializationFeature.INDENT_OUTPUT)
        enable(SerializationFeature.WRAP_ROOT_VALUE)
    }
   val xml = mapper.writeValueAsString(element)
    fichier.writeText(xml)

}

fun loadFiles(path: String) {
    val dossier = File(path)
   dossier.listFiles()?.forEach {
    file ->
        if (file.name.startsWith("export")) {
            println("${file.name} commence par 'export'")


        }
       if(file.name.startsWith("import")) {
           println("${file.name} commence par 'import'")
       }

    }
}

fun loadFiles2(path: String) {
    val dossier = File(path)
    dossier.listFiles()?.apply {
        forEach { file->
            if (file.name.startsWith("export")) {
                println("${file.name} commence par 'export'")
            }
        }

    }?.run {

        forEach { file->
            if (file.name.startsWith("import")) {
                println("${file.name} commence par 'export'")
            }
        }
    }

}






