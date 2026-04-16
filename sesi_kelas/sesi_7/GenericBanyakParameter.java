public class GenericBanyakParameter {

    static class DataStore<K, V> {
        private K data1;
        private V data2;

        public void simpan(K data1, V data2) {
            this.data1 = data1;
            this.data2 = data2;
        }

        public K getKey() {
            return data1;
        }

        public V getVal() {
            return data2;
        }
    }

    public static void main(String[] args) {
        DataStore<String, Double> transaksi = new DataStore<>();
        transaksi.simpan("TRX-1001", 150000.0);

        DataStore<String, Integer> pelanggan = new DataStore<>();
        pelanggan.simpan("CUST-01", 320);

        System.out.println("Transaksi : " + transaksi.getKey() + " | Rp" + transaksi.getVal());
        System.out.println("Pelanggan : " + pelanggan.getKey() + " | Poin " + pelanggan.getVal());
    }
    
}
