package utility;

import models.Person;
import repository.PersonRepository;

import java.util.Scanner;

public class PersonRegex {
    public static void setPhone (int idPerson) throws EntityNotFoundException {
        final String rule = "(\\+*)\\d{12}";
        System.out.println(PersonRepository.getInstance().getPersonList());
        System.out.println("Введіть номер телефона в наступному форматі: +хххххххххххx.");
        Scanner scannerP = new Scanner(System.in);
        String phone = scannerP.nextLine();
        String phoneNorm = phone.trim();
        boolean result = phoneNorm.matches(rule);
        while (!result) {
            try {
                throw new SetParameterException("Ви ввели некоректний телефон!");
            } catch (SetParameterException e) {
                System.err.println("Введіть телефон знову у правильному форматі!");
                phone = scannerP.nextLine();
                phoneNorm = phone.trim();
                result = phoneNorm.matches(rule);
            }
        }
        System.out.println("Номер телефона:  " + phoneNorm);
        Person person = PersonRepository.getInstance().getById(idPerson);
        person.setPhone(phoneNorm);
    }
    public static void setFirstname (int idPerson) throws EntityNotFoundException {
        final String rule = "^([A-Za-z][A-Za-z\\-']{1,50})|([А-ЯIЇҐЄа-яіїґє][А-ЯIЇҐЄа-яіїґє\\-']{1,50})$";
        System.out.println(PersonRepository.getInstance().getPersonList());
        System.out.println("Введіть необхідне ім'я!");
        Scanner scannerP = new Scanner(System.in);
        String firstname = scannerP.nextLine();
        String firstnameNorm = firstname.trim();
        boolean result = firstnameNorm.matches(rule);
        while (!result) {
            try {
                throw new SetParameterException("Ви ввели некоректне ім'я!");
            } catch (SetParameterException e) {
                System.err.println("Введіть ім'я знову в правильному форматі!");
                firstname = scannerP.nextLine();
                firstnameNorm = firstname.trim();
                result = firstnameNorm.matches(rule);
            }
        }
        System.out.println("Ім'я:  " + firstnameNorm);
        Person person = PersonRepository.getInstance().getById(idPerson);
        person.setFirstname(firstnameNorm);
    }

    public static void setLastname (int idPerson) throws EntityNotFoundException {
        final String rule = "^([A-Za-z][A-Za-z\\-']{1,100})|([А-ЯIЇҐЄа-яіїґє][А-ЯIЇҐЄа-яіїґє\\-']{1,100})$";
        System.out.println(PersonRepository.getInstance().getPersonList());
        System.out.println("Введіть необхідне прізвище!");
        Scanner scannerP = new Scanner(System.in);
        String lastname = scannerP.nextLine();
        String lastnameNorm = lastname.trim();
        boolean result = lastnameNorm.matches(rule);
        while (!result) {
            try {
                throw new SetParameterException("Ви ввели некоректне прізвище!");
            } catch (SetParameterException e) {
                System.err.println("Введіть прізвище знову в правильеому форматі!");
                lastname = scannerP.nextLine();
                lastnameNorm = lastname.trim();
                result = lastnameNorm.matches(rule);
            }
        }
        System.out.println("Прізвище:  " + lastnameNorm);
        Person person = PersonRepository.getInstance().getById(idPerson);
        person.setLastname(lastnameNorm);
    }

    public static void setEmail (int idPerson) throws EntityNotFoundException {
        final String rule = "^([a-z0-9_.-]+)@([\\da-z.-]+)\\.([a-z.]{2,6})$";
        System.out.println(PersonRepository.getInstance().getPersonList());
        System.out.println("Введіть необхідну поштову скриньку!");
        Scanner scannerP = new Scanner(System.in);
        String email = scannerP.nextLine();
        String emailNorm = email.trim();
        boolean result = emailNorm.matches(rule);
        while (!result){
            try {
                throw new SetParameterException("Ви ввели некоректну поштову скриньку!");
            } catch (SetParameterException e) {
                System.err.println("Введіть поштову скриньку в правильному форматі!");
                email = scannerP.nextLine();
                emailNorm = email.trim();
                result = emailNorm.matches(rule);
            }
        }

        System.out.println("Поштова скринька:  " + emailNorm);
        Person person = PersonRepository.getInstance().getById(idPerson);
        person.setEmail(emailNorm);
    }
}