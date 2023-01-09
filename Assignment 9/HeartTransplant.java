/**
 * 
 * HeartTransplant class
 * 
 * @author Ana Paula Centeno
 * @author Haolin (Daniel) Jin
 * @author Rey Riordan rhr58 reyriordan@gmail.com
 */
public class HeartTransplant {

    // patient array, each Patient is read from the data file
    private Patient[] patients;

    // SurvivabilityByAge array, each rate is read from data file
    private SurvivabilityByAge survivabilityByAge;

    // SurvivabilityByCause array, each rate is read from data file
    private SurvivabilityByCause survivabilityByCause;

    /*
     * Default constructor
     * Initializes patients to null.
     * Initializes survivabilityByAge to null.
     * Initializes survivabilityByCause to null. 
     */
    public HeartTransplant() {

        this.patients = new Patient[0];
        this.survivabilityByAge = new SurvivabilityByAge();
        this.survivabilityByCause = new SurvivabilityByCause();
    }

    /*
     * Returns patients
     */
    public Patient[] getPatients() {
        return patients;
     } 

    /*
     * Returns survivabilityByAge
     */
    public SurvivabilityByAge getSurvivabilityByAge() {
        return survivabilityByAge;
    }

    /*
     * Returns survivabilityByCause
     */
    public SurvivabilityByCause getSurvivabilityByCause() {
        return survivabilityByCause;
    }

    /*
     * 1) Initialize the instance variable patients array with numberOfLines length.
     * 
     * 2) Reads from the command line data file, use StdIn.readInt() to read an integer.
     *    File Format: 
     *      ID, ethnicity, Gender, Age, Cause, Urgency, State of health
     * 
     *    Each line refers to one Patient, all values are integers.
     * 
     */
    public void readPatients (int numberOfLines) {
        patients = new Patient[numberOfLines];
        for(int i = 0; i < numberOfLines; i++){
            int id = StdIn.readInt();
            int ethnicity = StdIn.readInt();
            int gender = StdIn.readInt();
            int age = StdIn.readInt();
            int cause = StdIn.readInt();
            int urgency = StdIn.readInt();
            int state = StdIn.readInt();
            patients[i] = new Patient(id, ethnicity, gender, age, cause, urgency, state);

        }
    }

    /*
     * 1) Initialize the instance variable survivabilityByAge with a new survivabilityByAge object.
     * 
     * 2) Reads from the command line file to populate the object. 
     *    Use StdIn.readInt() to read an integer and StdIn.readDouble() to read a double.
     * 
     *    File Format: Age YearsPostTransplant Rate
     *    Each line refers to one survivability rate by age.
     * 
     */
    public void readSurvivabilityByAge (int numberOfLines) {
        survivabilityByAge = new SurvivabilityByAge();
        for(int i = 0; i < numberOfLines; i++){
            int age = StdIn.readInt();
            int year = StdIn.readInt();
            double rate = StdIn.readDouble();
            survivabilityByAge.addData(age, year, rate);
        }
    }

    /*
     * 1) Initialize the instance variable survivabilityByCause with a new survivabilityByCause object.
     * 
     * 2) Reads from the command line file to populate the object. Use StdIn.readInt() to read an 
     *    integer and StdIn.readDouble() to read a double.
     * 
     *    File Format: Cause YearsPostTransplant Rate
     *    Each line refers to one survivability rate by cause.
     * 
     */
    public void readSurvivabilityByCause (int numberOfLines) {
        survivabilityByCause = new SurvivabilityByCause();
        for(int i = 0; i < numberOfLines; i++){
            int cause = StdIn.readInt();
            int year = StdIn.readInt();
            double rate = StdIn.readDouble();
            survivabilityByCause.addData(cause, year, rate);
        }
    }
    
    /*
     * Returns a Patient array containing the patients, 
     * from the patients array, that have age above the parameter age.
     * 
     * The return array has to be completely full with no empty
     * spots, that is the array size should be equal to the number
     * of Patients with age above the parameter age.
     * 
     * Return null if there is no Patient with age above the 
     * parameter age.
     */ 
    public Patient[] getPatientsWithAgeAbove(int age) {
        int n = 0;
        for(Patient patient : patients){
            if(patient.getAge() >= age){
                n++;
            }
        }
        if(n > 0){
            int x = 0;
            Patient[] validPatients = new Patient[n];
            for(int i = 0; i < patients.length; i++){
                if(patients[i].getAge() >= age){
                    validPatients[x] = patients[i];
                    x++;
                }
            }
            return validPatients;
        }
        return null;
    }

    /*
     * Returns a Patient array containing the patients, from the patients array, 
     * that have the heart condition cause equal to the parameter cause.
     * 
     * The return array has to be completely full with no empty
     * spots, that is the array size should be equal to the number
     * of Patients with the heart condition cause equal to the parameter cause.
     * 
     * Return null if there is no Patient with the heart condition cause 
     * equal to the parameter cause.
     */ 
    public Patient[] getPatientsByHeartConditionCause(int cause) {
        int n = 0;
        for(Patient patient : patients){
            if(patient.getCause() == cause){
                n++;
            }
        }
        if(n > 0){
            int x = 0;
            Patient[] validPatients = new Patient[n];
            for(int i = 0; i < patients.length; i++){
                if(patients[i].getCause() == cause){
                    validPatients[x] = patients[i];
                    x++;
                }
            }
            return validPatients;
        }
        return null;
    }

    /*
     * Returns a Patient array containing patients, from the patients array,
     * that have the state of health equal to the parameter state.
     * 
     * The return array has to be completely full with no empty
     * spots, that is the array size should be equal to the number
     * of Patients with the state of health equal to the parameter state.
     * 
     * Return null if there is no Patient with the state of health 
     * equal to the parameter state.
     */ 
    public Patient[] getPatientsByUrgency(int urgency) {
        int n = 0;
        for(Patient patient : patients){
            if(patient.getUrgency() == urgency){
                n++;
            }
        }
        if(n > 0){
            int x = 0;
            Patient[] validPatients = new Patient[n];
            for(int i = 0; i < patients.length; i++){
                if(patients[i].getUrgency() == urgency){
                    validPatients[x] = patients[i];
                    x++;
                }
            }
            return validPatients;
        }
	    return null;
    }

    /*
     * Assume there is a heart available for transplantation surgery.
     * Also assume that the heart is of the same blood type as the
     * Patients on the patients array.
     * This method finds the Patient to be the recepient of this
     * heart.
     * 
     * The method returns a Patient from the patients array with
     * he highest potential for survivability after the transplant.
     * 
     * Assume the patient returned by this method will receive a heart,
     * therefore the Patient will no longer need a heart.
     * 
     * There is no correct solution, you may come up with any 
     * function to find the patient with the highest potential 
     * for survivability after the transplant.
     */ 
    public Patient getPatientForTransplant () {
        Patient bestPatient = patients[0];
        double highestRate = 0.0;
        for(Patient patient : patients){
            if(patient.getNeedHeart() == true){
                double ageRate = survivabilityByAge.getRate(patient.getAge(), 5);
                double causeRate = survivabilityByCause.getRate(patient.getCause(), 5);
                double avgRate = (ageRate + causeRate)/2;
                if(patient.getUrgency() > bestPatient.getUrgency()){
                    bestPatient = patient;
                    highestRate = avgRate;
                }else if(patient.getUrgency() >= bestPatient.getUrgency() && avgRate > highestRate){
                    bestPatient = patient;
                    highestRate = avgRate;
                }
            }
        }
        bestPatient.setNeedHeart(false);
	    return bestPatient;
    }
}
