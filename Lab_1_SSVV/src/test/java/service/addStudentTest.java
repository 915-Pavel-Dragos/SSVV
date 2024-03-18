package service;

import domain.Student;
import junit.framework.TestCase;
import repository.*;
import validation.NotaValidator;
import validation.StudentValidator;
import validation.TemaValidator;

public class addStudentTest extends TestCase {

    public void testAddStudent() {
        StudentXMLRepo stud_XML_rep = new StudentXMLRepo("fisiere/Studenti.xml");
        NotaXMLRepo nota_XML_rep = new NotaXMLRepo("fisiere/Note.xml");
        TemaXMLRepo teme_XML_rep = new TemaXMLRepo("fisiere/Teme.xml");
        StudentValidator studentValidator = new StudentValidator();
        TemaValidator temaValidator = new TemaValidator();
        NotaValidator notaValidator = new NotaValidator(stud_XML_rep, teme_XML_rep);
        Service service = new Service(stud_XML_rep, studentValidator, teme_XML_rep, temaValidator, nota_XML_rep, notaValidator);
        Student student = new Student("234", "Andrei", Integer.MAX_VALUE + 1, "andrei@gmail.com");
        Student result = service.addStudent(student);
        assertEquals(student, result);
    }
}