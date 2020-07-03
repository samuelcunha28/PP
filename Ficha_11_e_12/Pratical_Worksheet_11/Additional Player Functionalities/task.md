# Ficha 11

---

## Interface e excepções

artindo do exercício 1, aumente a robustez e realismo do PPod, acrescentando as seguintes funcionalidades: 
- O método ``playTrack`` gera excepção quando a duração do ficheiro é inválida. 
- O método ``addFile`` gera excepção quando o tamanho do ficheiro é inválido. 
- Um novo método ``shufflePlay()`` que reordena os ficheiros do player segundo um algoritmo com que o player foi configurado na inicialização e reproduz automaticamente a primeira faixa válida que encontrar, a partir do início da memória. A implementação do player não deve ter qualquer dependência sobre quaisquer algoritmos de reordenação. O player apenas sabe como invocar a reordenação. Implemente os seguintes algoritmos de reordenação: por nome (ascendente), por tamanho do ficheiro (descendente), e por duração da faixa (ascendente). A aplicação PPodDemo deve também testar players inicializados com diferentes algoritmos de reordenação. 
- Implemente um método ``list`` que imprima no ecrã o nome das faixas válidas, ordenadas pelo índice. 
- Implemente um método ``getGlobalAddFileFailures`` que permita à empresa produtora do PPod saber quantas vezes o método addFile originou excepções nos seus players. Note que esta informação é global a todos os players e não diz respeito a um player em particular.

## Objectivo

Implemente as funcionalidades pedidas e altere os métodos ``playTrack`` e ``addFile`` tornando-os mais robustos.