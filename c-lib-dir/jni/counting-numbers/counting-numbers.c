#include <stdio.h>
#if defined(_WIN64)
  #include <windows.h>
#endif

int count(char* args) {

  char *file_name = args;

  FILE *arquivo = fopen(file_name, "w");

  if (arquivo == NULL) {
    return 1;
  }

  for (int i = 0; i < 10000; i++) {
    fprintf(arquivo, "%d\n", i+1);
  }

  fclose(arquivo);

  return 0;
}

int main(int argc, char *argv[]) {
    return count(argv[0]);
}