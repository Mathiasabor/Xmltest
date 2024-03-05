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

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val dossier = File("C:\\Users\\mathi\\Desktop\\TP1")
    val dossierpath ="C:\\Users\\mathi\\Desktop\\TP1"
    val divider = File.separator
    val mapper = XmlMapper()

   val famille1 = Famille()
    val famille2 = Famille("Mathias", 25, true, listOf(Person("John", 25, false), Person("Jane", 25, false)))

    val xml = """
    <?xml version="1.0" encoding="UTF-8"?>
    <!DOCTYPE Movie SYSTEM "famille2.dtd">
    
    ${ mapper.writeValueAsString(famille2)}
    
    """.trimIndent()



    val fichier = File(dossierpath + divider + "famille2.xml")
    //val dxml = fichier.readText()
   // val fmille = mapper.readValue(dxml, Famille::class.java)
   // fmille.children.forEach { println(it.name) }
    fichier.writeText(xml)


}

//@JsonIgnoreProperties(ignoreUnknown = true)
class Person (
    var nameou: String = "John",
    var ageou: Int = 25,
    var isMarriedou: Boolean =false
): Serializable
@JacksonXmlRootElement(localName = "Family")
class Famille(
   @JacksonXmlProperty(localName = "nom-famille")
    var name: String = "John",
    @JacksonXmlProperty(localName = "age-personne")
    var age: Int = 25,
   @JacksonXmlProperty(localName ="mariage-personne")
    var isMarried: Boolean = false,
   @JacksonXmlProperty(localName ="enfants")
    var children: List<Person> = listOf(Person(), Person())): Serializable


