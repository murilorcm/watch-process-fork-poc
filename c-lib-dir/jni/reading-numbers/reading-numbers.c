#include <stdio.h>
#if defined(_WIN64)
  #include <windows.h>
#endif

int read(char* args) {

  char *file_name = args;

    FILE *arquivo = fopen(file_name, "r");

    if (arquivo == NULL) {
      return 1;
    }

    int num;

    while (fscanf(arquivo, "%d", &num) != EOF) {
      printf("%d\n", num);
    }

    fclose(arquivo);

  return 0;
}

int main(int argc, char *argv[]) {
    return read(argv[0]);
}