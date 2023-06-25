import java.util.*;

class AFD {
    private Set<String> states;
    private Set<String> alphabet;
    private Map<String, Map<String, String>> transitions;
    private String startState;
    private Set<String> acceptingStates;

    public AFD(Set<String> states, Set<String> alphabet, Map<String, Map<String, String>> transitions,
            String startState, Set<String> acceptingStates) {
        this.states = states;
        this.alphabet = alphabet;
        this.transitions = transitions;
        this.startState = startState;
        this.acceptingStates = acceptingStates;
    }

    public AFD minimize() {
        // Passo 1: Inicialização
        // Cria uma tabela de distinção
        boolean[][] distinctionTable = new boolean[states.size()][states.size()];

        // Marca os pares (p, q) onde p está em F (estados de aceitação) e q não está em F
        int i = 0;
        for (String stateP : states) {
            int j = 0;
            for (String stateQ : states) {
                if ((acceptingStates.contains(stateP) && !acceptingStates.contains(stateQ))
                        || (acceptingStates.contains(stateQ) && !acceptingStates.contains(stateP))) {
                    distinctionTable[i][j] = true;
                }
                j++;
            }
            i++;
        }

        // Passo 2: Preenchimento da tabela de distinção
        boolean changed = true;
        while (changed) {
            changed = false;
            for (i = 0; i < states.size(); i++) {
                for (int j = i + 1; j < states.size(); j++) {
                    if (!distinctionTable[i][j]) {
                        for (String symbol : alphabet) {
                            String stateP = transitions.get(states.get(i)).get(symbol);
                            String stateQ = transitions.get(states.get(j)).get(symbol);
                            int indexP = states.indexOf(stateP);
                            int indexQ = states.indexOf(stateQ);
                            if (distinctionTable[indexP][indexQ]) {
                                distinctionTable[i][j] = true;
                                changed = true;
                                break;
                            }
                        }
                    }
                }
            }
        }

        // Passo 3: Geração do AFD minimizado
        List<Set<String>> partition = new ArrayList<>();
        partition.add(new HashSet<>(acceptingStates));
        partition.add(new HashSet<>(states));
        List<List<String>> minimizedStates = new ArrayList<>();
        Map<List<String>, Map<String, List<String>>> minimizedTransitions = new HashMap<>();
        List<List<String>> minimizedAcceptingStates = new ArrayList<>();

        for (i = 0; i < states.size(); i++) {
            for (int j = i + 1; j < states.size(); j++) {
                if (!distinctionTable[i][j]) {
                    // Mescla os estados equivalentes em uma mesma partição
                    for (int k = 0; k < partition.size(); k++) {
                        Set<String> group = partition.get(k);
                        if (group.contains(states.get(i))) {
                            group.add(states.get(j));
                            break;
                        }
                        if (k == partition.size() - 1) {
                            partition.add(new HashSet<>(Arrays.asList(states.get(i), states.get(j))));
                        }
                    }
                }
            }
        }

        // Atualiza os conjuntos de estados do AFD minimizado
        for (Set<String> group : partition) {
            minimizedStates.add(new ArrayList<>(group));
        }

        // Atualiza o estado inicial do AFD minimizado
        List<String> minimizedStartState = null;
        for (List<String> group : minimizedStates) {
            if (group.contains(startState)) {
                minimizedStartState = group;
                break;
            }
        }

        // Atualiza os estados de aceitação do AFD minimizado
        for (Set<String> group : partition) {
            if (acceptingStates.stream().anyMatch(group::contains)) {
                minimizedAcceptingStates.add(new ArrayList<>(group));
            }
        }

        // Atualiza as transições do AFD minimizado
        for (Set<String> group : partition) {
            String representative = group.iterator().next();
            Map<String, List<String>> groupTransitions = new HashMap<>();
            for (String symbol : alphabet) {
                String nextState = transitions.get(representative).get(symbol);
                for (int k = 0; k < partition.size(); k++) {
                    Set<String> pGroup = partition.get(k);
                    if (pGroup.contains(nextState)) {
                        groupTransitions.put(symbol, new ArrayList<>(pGroup));
                        break;
                    }
                    if (k == partition.size() - 1) {
                        throw new IllegalArgumentException("Transição inválida!");
                    }
                }
            }
            minimizedTransitions.put(new ArrayList<>(group), groupTransitions);
        }

        return new AFD(minimizedStates, alphabet, minimizedTransitions, minimizedStartState,
                minimizedAcceptingStates);
    }

    public void displayInfo() {
        System.out.println("States: " + states);
        System.out.println("Alphabet: " + alphabet);
        System.out.println("Initial State: " + startState);
        System.out.println("Accepting States: " + acceptingStates);
        System.out.println("Transitions:");
        for (String state : states) {
            for (String symbol : alphabet) {
                String nextState = transitions.get(state).get(symbol);
                System.out.println(state + " --(" + symbol + ")--> " + nextState);
            }
        }
    }
}

class Main {
    private static Set<String> states = new HashSet<>();
    private static Set<String> alphabet = new HashSet<>();
    private static Map<String, Map<String, String>> transitions = new HashMap<>();
    private static String startState;
    private static Set<String> acceptingStates = new HashSet<>();

    private static void processLine(String line) {
        line = line.strip();
        if (line.startsWith("alphabet")) {
            String alphabetLine = line;
            alphabet.addAll(Arrays.asList(eval(alphabetLine.split("=")[1].strip())));
        } else if (line.startsWith("states")) {
            String statesLine = line;
            states.addAll(Arrays.asList(eval(statesLine.split("=")[1].strip())));
        } else if (line.startsWith("initial")) {
            String initialLine = line;
            startState = eval(initialLine.split("=")[1].strip());
        } else if (line.startsWith("finish")) {
            String finishLine = line;
            acceptingStates.addAll(Arrays.asList(eval(finishLine.split("=")[1].strip())));
        } else if (line.startsWith("transitions")) {
            String transitionsLine = line;
            Map<String, String> transitionsList = eval(transitionsLine.split("=")[1].strip());
            for (Map.Entry<String, String> entry : transitionsList.entrySet()) {
                String state = entry.getKey();
                String symbol = entry.getValue();
                String nextState = transitionsList.get(entry);
                if (!transitions.containsKey(state)) {
                    transitions.put(state, new HashMap<>());
                }
                transitions.get(state).put(symbol, nextState);
            }
        }
    }

    private static void processFile() {
        for (String line : linhas) {
            processLine(line);
        }
    }

    public static void main(String[] args) {
        // Abrir o arquivo
        try {
            File arquivo = new File("automato.txt");
            Scanner scanner = new Scanner(arquivo);

            // Ler as linhas do arquivo
            List<String> linhas = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                linhas.add(linha);
            }

            // Fechar o arquivo
            scanner.close();

            processFile();
            AFD afd = new AFD(states, alphabet, transitions, startState, acceptingStates);
            AFD minimizedAFD = afd.minimize();

            System.out.println("Estados do AFD minimizado: " + minimizedAFD.getStates());
            System.out.println("Transições do AFD minimizado: " + minimizedAFD.getTransitions());
            System.out.println("Estado inicial do AFD minimizado: " + minimizedAFD.getStartState());
            System.out.println("Estados de aceitação do AFD minimizado: " + minimizedAFD.getAcceptingStates());

            minimizedAFD.displayInfo();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
