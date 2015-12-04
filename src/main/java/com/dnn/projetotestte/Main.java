/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dnn.projetotestte;

/**
 *
 * @author DeividnN
 */
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

public class Main {

    static final Projeto projeto = new Projeto();

    static {
        List<Pacote> pacotes = new ArrayList<>();

        Pacote p1 = new Pacote();
        p1.setNome("pacote1");
        p1.setPrefixo("pacote1");
        p1.setUri("pacote1");

        List<Classe> classes1 = new ArrayList<>();
        Classe c1 = new Classe();
        c1.setTipo("ecore:EClass");
        c1.setNome("Animal");

        Classe c2 = new Classe();
        c2.setTipo("ecore:EClass");
        c2.setNome("Cachorro");
        c2.setSupertipo("Animal");
        classes1.add(c2);
        p1.setClasses(classes1);
        pacotes.add(p1);

        Pacote p2 = new Pacote();
        p2.setNome("pacote2");
        p2.setPrefixo("pacote2");
        p2.setUri("pacote2");

        List<Classe> classes2 = new ArrayList<>();
        Classe c3 = new Classe();
        c3.setTipo("ecore:EClass");
        c2.setNome("Pessoa");
        classes2.add(c3);
        p2.setClasses(classes2);
        pacotes.add(p2);

        projeto.setNome("projeto1");
        projeto.setVersao("2.0");
        projeto.setUri("projeto1");
        projeto.setPrefixo("projeto1");
        projeto.setPacote(pacotes);
    }

    public static void main(String[] args) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Projeto.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        //Marshal the employees list in console
        jaxbMarshaller.marshal(projeto, System.out);

        //Marshal the employees list in file
        jaxbMarshaller.marshal(projeto, new File("C:\\projeto.xml"));
    }

    @XmlRootElement(name = "ecore:EPackage")
    @XmlAccessorType(XmlAccessType.FIELD)
    static public class Projeto {

        @XmlAttribute(name = "xmi:version")
        private String versao;

        @XmlAttribute(name = "name")
        private String nome;

        @XmlAttribute(name = "nsURI")
        private String uri;

        @XmlAttribute(name = "nsPrefix")
        private String prefixo;

        @XmlElement(name = "eSubpackages")
        private List<Pacote> pacote = null;

        public String getVersao() {
            return versao;
        }

        public void setVersao(String versao) {
            this.versao = versao;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }

        public String getPrefixo() {
            return prefixo;
        }

        public void setPrefixo(String prefixo) {
            this.prefixo = prefixo;
        }

        public List<Pacote> getPacote() {
            return pacote;
        }

        public void setPacote(List<Pacote> pacote) {
            this.pacote = pacote;
        }

    }

    @XmlRootElement(name = "eSubpackages")
    @XmlAccessorType(XmlAccessType.FIELD)
    static public class Pacote {

        @XmlAttribute(name = "name")
        private String nome;

        @XmlAttribute(name = "nsURI")
        private String uri;

        @XmlAttribute(name = "nsPrefix")
        private String prefixo;

        @XmlElement(name = "eClassifiers")
        private List<Classe> classes = null;

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }

        public String getPrefixo() {
            return prefixo;
        }

        public void setPrefixo(String prefixo) {
            this.prefixo = prefixo;
        }

        public List<Classe> getClasses() {
            return classes;
        }

        public void setClasses(List<Classe> classes) {
            this.classes = classes;
        }

    }

    @XmlRootElement(name = "eClassifiers")
    @XmlAccessorType(XmlAccessType.FIELD)
    static public class Classe {

        @XmlAttribute(name = "xsi:type")
        private String tipo;

        @XmlAttribute(name = "eSuperTypes")
        private String supertipo;

        @XmlAttribute(name = "name")
        private String nome;

        public String getTipo() {
            return tipo;
        }

        public void setTipo(String tipo) {
            this.tipo = tipo;
        }

        public String getSupertipo() {
            return supertipo;
        }

        public void setSupertipo(String supertipo) {
            this.supertipo = supertipo;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

    }

}
