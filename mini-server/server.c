#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <arpa/inet.h>

#define PORT 8080
#define BUFFER_SIZE 1024

int main() {
  int server_fd = socket(AF_INET, SOCK_STREAM, 0);
  if (server_fd < 0) {
    perror("socket failed");
    exit(1);
  }
  int opt = 1;
  setsockopt(server_fd, SOL_SOCKET, SO_REUSEADDR, &opt, sizeof(opt));
  struct sockaddr_in server_addr;
  memset(&server_addr, 0, sizeof(server_addr));
  server_addr.sin_family = AF_INET;
  server_addr.sin_addr.s_addr = INADDR_ANY;
  server_addr.sin_port = htons(PORT);
  if (bind(server_fd, (struct sockaddr *)&server_addr, sizeof(server_addr)) < 0) {
    perror("bind failed");
    exit(1);
  }
  if (listen(server_fd, 5) < 0) {
    perror("listen failed");
    close(server_fd);
    exit(1);
  }
  printf("Listening on port %d\n", PORT);
  for (;;) {
    struct sockaddr_in cli;
    socklen_t len = sizeof(cli);
    int client = accept(server_fd, (struct sockaddr *)&cli, &len);
    if (client < 0) {
        perror("accept failed");
       continue;
    }
    close(client);
  }
  void send_ok_header(int client) {
    const char *header = "HTTP/1.1 200 OK\r\n"
                          "Content-Type: text/html\r\n"
                          "\r\n";
    send(client, header, strlen(header), 0);
  }
  void send_file(int client, const char *path) {
    FILE *file = fopen(path, "r");
    if (!file) {
      perror("fopen failed"); return;
    }
    char buffer[BUFFER_SIZE];
    size_t bytes_read;
    while ((bytes_read = fread(buffer, 1, BUFFER_SIZE, file)) > 0) {
      send(client, buffer, bytes_read, 0);
    }
    fclose(file);
  }
  printf("client connected\n");
  send_ok_header(1);
  send_file(1, "/home/plasma/mini-server/index.html");
  printf("client disconnected\n");
  close(1);
  return 0;
}
