package org.example

import com.fasterxml.jackson.annotation.JsonAlias
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement
import com.fasterxml.jackson.module.kotlin.KotlinModule
import java.io.File
import java.io.Serializable
val divider = File.separator
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val dossier = File("C:\\Users\\mathi\\Desktop\\TP1")
    val dossierpath ="C:\\Users\\mathi\\Desktop\\TP1"

    val mapper = XmlMapper()


    val famille2 = Famille("Mathias2", 25, true, mutableListOf(Person("John", 25, false), Person("Jane", 25, false)))
    saveToXml("famille2", famille2, dossierpath)
    //val fichier = File(dossierpath + divider + "famille2.xml")
    //val dxml = fichier.readText()
    //val fmille = mapper.readValue(dxml, Famille::class.java)
   //fmille.children.forEach { println(it.name) }



}

@JacksonXmlRootElement(localName = "person")
class Person (
    @JacksonXmlProperty(localName = "nom")
    var name: String = "John",
    @JacksonXmlProperty(localName = "age")
    var age: Int = 25,
    @JacksonXmlProperty(localName = "estmarrier")
    var isMarried: Boolean =false
): Serializable

@JacksonXmlRootElement(localName = "famille")
class Famille(
@JacksonXmlProperty(localName = "nom")
    var name: String = "John",

@JacksonXmlProperty(localName = "age")
    var age: Int = 25,
@JacksonXmlProperty(localName = "isMarried")
    var isMarried: Boolean = false,
@JacksonXmlProperty(localName = "enfants")
    var children: MutableList<Person> = mutableListOf(Person(), Person())
): Serializable

fun saveToXml(name: String, element : Any, path : String){

    val fichier = File(path + divider+ "$name.xml")
    val mapper = XmlMapper()
   val xml = mapper.writeValueAsString(element)
    fichier.writeText(xml)

}


