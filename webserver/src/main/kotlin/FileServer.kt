import ru.sber.filesystem.VFilesystem
import ru.sber.filesystem.VPath
import java.io.IOException
import java.io.PrintWriter
import java.net.ServerSocket
import java.net.Socket

/**
 * A basic and very limited implementation of a file server that responds to GET
 * requests from HTTP clients.
 */
class FileServer {

    /**
     * Main entrypoint for the basic file server.
     *
     * @param socket Provided socket to accept connections on.
     * @param fs     A proxy filesystem to serve files from. See the VFilesystem
     *               class for more detailed documentation of its usage.
     * @throws IOException If an I/O error is detected on the server. This
     *                     should be a fatal error, your file server
     *                     implementation is not expected to ever throw
     *                     IOExceptions during normal operation.
     */
    @Throws(IOException::class)
    fun run(socket: ServerSocket, fs: VFilesystem) {

        while (true) {
            socket.accept().use {
                handle(it, fs)
            }
        }
    }

    private fun handle(socket: Socket, fs: VFilesystem) {
        val reader = socket.getInputStream().bufferedReader()
        val request = reader.readLine().split("\\s+".toRegex())
        val content = fs.readFile(VPath(request[1]))
        val response = getResponse(content)

        val writer = PrintWriter(socket.getOutputStream())
        writer.println(response)
        writer.flush()
    }

    private fun getResponse(content: String?): String {
        return if (content.isNullOrEmpty()) {
            "HTTP/1.0 404 Not Found\r\nServer: FileServer\r\n\r\n"
        } else {
            "HTTP/1.0 200 OK\r\nServer: FileServer\r\n\r\n$content"
        }
    }

}