public class CheckUp {

    private String afericaoMedica;

    public String getAfericaoMedica() {
        return afericaoMedica;
    }

    public void setAfericaoMedica(String afericaoMedica) {
        this.afericaoMedica = afericaoMedica;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CheckUp{");
        sb.append("afericaoMedica='").append(afericaoMedica).append('\'');
        sb.append('}');
        return sb.toString();
    }

}
