package org.adv.pdfmaker;

public class SelectorOptions {
    private boolean copyMetadata = false;
    private boolean copyIntents = false;

    public static final SelectorOptions COPY_PDFA_PROPERTIES = SelectorOptions.with().copyMetadata().copyIntents();
    public static final SelectorOptions CREATE_NEW = SelectorOptions.with();

    private SelectorOptions() {
    }

    public static SelectorOptions with() {
        return new SelectorOptions();
    }

    public SelectorOptions copyMetadata() {
        this.copyMetadata = true;
        return this;
    }

    public SelectorOptions copyIntents() {
        this.copyIntents = true;
        return this;
    }

    public boolean isCopyMetadataEnabled() {
        return copyMetadata;
    }

    public boolean isCopyIntentsEnabled() {
        return copyIntents;
    }
}
