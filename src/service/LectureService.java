package service;
import models.Lecture;

public class LectureService {
    public Lecture createLecture() {
        return new Lecture();
    }

    public Lecture createLecture(int idCourse) {
        this.idCourse = idCourse;
        return new Lecture();

    }

}