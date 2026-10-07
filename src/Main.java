void main() {
    Scanner sc = new Scanner(System.in);

    List<Pessoa> banco = new ArrayList<>();

    banco.add(new Pessoa(1, "João", 25));
    banco.add(new Pessoa(2, "Maria", 30));
    banco.add(new Pessoa(3, "Carlos", 22));
    banco.add(new Pessoa(4, "Ana", 28));
    banco.add(new Pessoa(5, "Pedro", 35));

    List<Pessoa> cache = new ArrayList<>();

    while (true) {
        IO.println("Digite o ID da pessoa (0 para sair): ");
        int idProcura = sc.nextInt();

        if (idProcura == 0) {
            break;
        }

        for(Pessoa pessoa : cache){
            if(pessoa.getId() == idProcura){
                IO.println("Pessoa encontrada no cache: " + pessoa);
                break;
            }
        }

        Pessoa encontrada = null;
        for (Pessoa pessoa : banco) {
            if (pessoa.getId() == idProcura) {
                encontrada = pessoa;
                break;
            }
        }

        if (encontrada != null) {
            if (cache.size() == 10) {
                cache.remove(0);
            }
            cache.add(encontrada);
            IO.println("Pessoa buscada no banco e adicionada ao cache: " + encontrada);
        } else {
            IO.println("Pessoa não encontrada no banco.");
        }
    }
}