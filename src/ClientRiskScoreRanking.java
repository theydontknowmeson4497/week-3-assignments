class Client {
    String name;
    int riskScore;
    double accountBalance;

    Client(String name, int riskScore, double accountBalance) {
        this.name = name;
        this.riskScore = riskScore;
        this.accountBalance = accountBalance;
    }

    @Override
    public String toString() {
        return name + "(" + riskScore + ", $" + accountBalance + ")";
    }
}

public class ClientRiskScoreRanking {

    // Bubble Sort: ascending by riskScore
    public static void bubbleSort(Client[] clients) {
        int n = clients.length;
        int swaps = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (clients[j].riskScore > clients[j + 1].riskScore) {
                    Client temp = clients[j];
                    clients[j] = clients[j + 1];
                    clients[j + 1] = temp;
                    swaps++;
                    System.out.println("Swap: " + clients[j] + " <-> " + clients[j + 1]);
                }
            }
        }
        System.out.println("BubbleSort completed with " + swaps + " swaps.");
    }

    // Insertion Sort: descending by riskScore, then accountBalance
    public static void insertionSort(Client[] clients) {
        int n = clients.length;
        for (int i = 1; i < n; i++) {
            Client key = clients[i];
            int j = i - 1;
            while (j >= 0 &&
                    (clients[j].riskScore < key.riskScore ||
                            (clients[j].riskScore == key.riskScore &&
                                    clients[j].accountBalance < key.accountBalance))) {
                clients[j + 1] = clients[j];
                j--;
            }
            clients[j + 1] = key;
        }
        System.out.println("InsertionSort completed.");
    }

    // Identify top 10 highest risk clients
    public static void topRisks(Client[] clients, int topN) {
        System.out.println("Top " + topN + " highest risk clients:");
        for (int i = 0; i < Math.min(topN, clients.length); i++) {
            System.out.println(clients[i]);
        }
    }

    public static void main(String[] args) {
        Client[] clients = {
                new Client("clientC", 80, 2000.0),
                new Client("clientA", 20, 5000.0),
                new Client("clientB", 50, 3000.0)
        };

        // Bubble Sort demo
        bubbleSort(clients);
        System.out.println("BubbleSort result (asc riskScore):");
        for (Client c : clients) System.out.println(c);

        // Reset array for insertion sort demo
        clients = new Client[]{
                new Client("clientC", 80, 2000.0),
                new Client("clientA", 20, 5000.0),
                new Client("clientB", 50, 3000.0)
        };

        insertionSort(clients);
        System.out.println("InsertionSort result (desc riskScore + balance):");
        for (Client c : clients) System.out.println(c);

        topRisks(clients, 3);
    }
}
