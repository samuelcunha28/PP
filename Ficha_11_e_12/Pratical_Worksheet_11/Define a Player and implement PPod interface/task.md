# Ficha 11

---

## Interface e excepções

O player a desenvolver é um ``PPod``, limitado a **100 MB** de espaço de memória, um máximo de **20 ficheiros**, e capaz de reproduzir apenas ficheiros com **extensão “mp3”**. 


O contrato da API ``PPod``, que permite dar suporte ao desenvolvimento do player desejado, estipula as seguintes funcionalidades:
 - ``addFile(File file)`` – adicionar um ficheiro ao player. Deve lidar com as exceções que ocorram ao longo do programa (null references, memória cheia, ou máximo de ficheiros atingido).
 - ``deleteFile(int index)`` – apagar um ficheiro do player. Este método deve contemplar a exceção de índices inválidos. Esta operação só está disponível se existirem álbuns armazenados.
 - ``playTrack(int index)`` – tenta reproduzir a faixa no índice indicado. A reprodução da faixa corresponde simplesmente a imprimir no ecrã os respectivos valores de “nome” e “duração”. Este
método deve contemplar a exceção de índices inválidos ou para ficheiros com extensões não
suportadas.
 - ``nextTrack()`` – avança para a faixa seguinte, “reproduzindo-a” automaticamente. Caso não seja
possível reproduzir o ficheiro corrente, deve saltar automaticamente para a faixa seguinte até
encontrar um ficheiro passível de ser reproduzido.
 - ``previousTrack()`` – recua para a faixa anterior, “reproduzindo-a” automaticamente. Caso não
seja possível reproduzir o ficheiro na faixa corrente, deve saltar automaticamente para a faixa anterior até encontrar um ficheiro passível de ser reproduzido.

## Objectivo

**Implemente o contrato pedido.**

Escreva o código necessário para testar o mais exaustivamente possível o código que desenvolveu como resposta ao que foi pedido. Sempre que for adequado, reutilize tipos de excepção da API Java. Quando os tipos de excepção da API Java não forem apropriados, declare um tipo de exceção específico desta aplicação.

A aplicação ``PPodDemo`` deve simular a execução do player de modo a provocar situações de falha e demonstrar a correcta reação do ``PPod`` sem provocar o término extemporâneo do programa.
