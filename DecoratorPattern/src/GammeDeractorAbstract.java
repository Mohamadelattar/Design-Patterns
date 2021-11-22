public abstract class GammeDeractorAbstract extends GammeAbstract{
    GammeAbstract gammeAbstract;

    public GammeDeractorAbstract(String gammeName, GammeAbstract gammeAbstract) {
        super(gammeName);
        this.gammeAbstract = gammeAbstract;
    }
    @Override
    public void info() {
        gammeAbstract.info();
        System.out.print("+ "+this.gammeName);
    }
}
