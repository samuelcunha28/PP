# Ficha 12

---

## Descrição 
Considere a resolução dos exercícios da ficha prática 11.

Adicione uma camada de persistência deve permitir guardar um objeto PPod completo. Posteriormente, o
objecto PPod deverá poder ser carregado para restaurar o estado do player PPod. Esta funcionalidade deve
imitar o comportamento padrão dos players mp3 que quando desligados guardam informação sobre o seu
estado. Este estado é recuperado assim que o dispositivo se liga.
Implemente o contrato ``IPPodSerializable`` para suportar uma camada de persistência que permita guardar o estado do player
PPod. Para isso, deverá dar suporte às seguintes funcionalidades:
- ``backup(String filePath)`` – guarda em ficheiro informação sobre as músicas existentes no
dispositivo.
- ``recover(String filePath)`` – recupera a informação guardada no ficheiro.

Deverá utilizar a interface Serializable para a implementação das funcionalidades backup e restore .
Implemente o contrato definido.

--- 
 
## Objetivo

Implemente o contrato ``IPPodSerializable`` na classe ``PPlayer``