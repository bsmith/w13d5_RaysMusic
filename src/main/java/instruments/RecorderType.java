package instruments;

public enum RecorderType {
    GARKLEIN(Tuning.C),
    SOPRANINO(Tuning.F),
    SOPRANO(Tuning.C),
    ALTO(Tuning.F),
    VOICEFLUTE(Tuning.D),
    TENOR(Tuning.C),
    BASS(Tuning.F),
    GREATBASS(Tuning.C),
    CONTRABASS(Tuning.F),
    SUBGREATBASS(Tuning.C),
    SUBCONTRABSS(Tuning.F);

    public enum Tuning {
        C, D, F;
    }

    private final Tuning tuning;

    RecorderType(Tuning tuning) {
        this.tuning = tuning;
    }

    public Tuning getTuning() {
        return tuning;
    }
}
