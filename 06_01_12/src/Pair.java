class Pair<T1,T2> {
    private T1 t1;
    private T2 t2;

    private Pair(T1 t1, T2 t2) {
        this.t1 = t1;
        this.t2 = t2;
    }

    public static <T1,T2> Pair <T1,T2> of (T1 t1, T2 t2) {
        return new Pair(t1, t2);
    }

    public T1 getFirst() {
        return this.t1;
    }

    public T2 getSecond() {
        return this.t2;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + t1.hashCode();
        result = prime * result + t2.hashCode();
        return result;    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Pair<?, ?> that = (Pair<?, ?>) obj;

        return ((this.t1 == null && that.getFirst() == null) || (this.t1 !=null && that.getFirst() != null && this.t1.equals(that.getFirst()))) &&
                ((this.t2 == null && that.getSecond() == null) || (this.t2 != null && that.getSecond() != null && this.t2.equals(that.getSecond())));
    }
}