class ExclusaoMutua {
    private boolean recursoDisponivel = true;

    public void secaoCritica() {
        // Entrar na seção crítica
        synchronized (this) {
            while (!recursoDisponivel) {
                try {
                    // Aguardar até que o recurso esteja disponível
                    wait();
                } catch (InterruptedException e) {
                    // Lidar com a exceção, se necessário
                    e.printStackTrace();
                }
            }

            // Acessar o recurso compartilhado
            System.out.println("Acessando a seção crítica...");

            // Simular algum processamento na seção crítica
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Indicar que o recurso não está mais disponível
            recursoDisponivel = false;

            // Sair da seção crítica
            System.out.println("Saindo da seção crítica...");
            notify(); // Notificar outros threads que o recurso foi alterado
        }
    }

    public void outraSecao() {
        // Entrar em uma seção não crítica
        System.out.println("Executando outra seção...");

        // Simular algum processamento na seção não crítica
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Indicar que o recurso está disponível novamente
        synchronized (this) {
            recursoDisponivel = true;
            notify(); // Notificar outros threads que o recurso foi alterado
        }
    }
}

class Main {
    public static void main(String[] args) {
        ExclusaoMutua exclusaoMutua = new ExclusaoMutua();

        Thread thread1 = new Thread(() -> {
            exclusaoMutua.secaoCritica();
        });

        Thread thread2 = new Thread(() -> {
            exclusaoMutua.outraSecao();
        });

        thread1.start();
        thread2.start();
    }
}
