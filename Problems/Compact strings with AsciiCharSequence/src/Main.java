import java.util.Arrays;

class AsciiCharSequence implements CharSequence /* extends/implements */ {
    private byte[] sequence;

    public AsciiCharSequence(byte[] sequence) {
        this.sequence = sequence.clone();
    }

    /**
     * @return
     */
    @Override
    public int length() {
        return this.sequence.length;
    }

    @Override
    public char charAt(int i) {
        return (char) this.sequence[i];
    }

    @Override
    public CharSequence subSequence(int i, int i1) {
        return new AsciiCharSequence(Arrays.copyOfRange(sequence, i, i1));
    }

    @Override
    public String toString() {
        return new String(this.sequence);
    }

    // implementation
}
