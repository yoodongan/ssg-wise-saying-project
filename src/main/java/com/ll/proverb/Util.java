package com.ll.proverb;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.stream.Stream;

public class Util {
    public static class file {
        public static void saveToFile(String path, String body) {
            try (RandomAccessFile stream = new RandomAccessFile(path, "rw");
                 FileChannel channel = stream.getChannel()) {
                byte[] strBytes = body.getBytes();
                ByteBuffer buffer = ByteBuffer.allocate(strBytes.length);
                buffer.put(strBytes);
                buffer.flip();
                channel.write(buffer);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public static void mkdir(String path) {
            new File(path).mkdirs();
        }

        public static String readFromFile(String path, String defaultValue) {
            try (RandomAccessFile reader = new RandomAccessFile(path, "r")) {
                StringBuilder sb = new StringBuilder();

                String line;

                boolean isFirst = true;

                while ((line = reader.readLine()) != null) {
                    if (isFirst == false) {
                        sb.append("\n");
                    }

                    sb.append(new String(line.getBytes("iso-8859-1"), "utf-8"));

                    isFirst = false;
                }

                return sb.toString();

            } catch (FileNotFoundException e) {
                return defaultValue;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public static void deleteDir(String path) {   // 디렉토리 삭제 기능.
            Path rootPath = Paths.get(path);
            try (Stream<Path> walk = Files.walk(rootPath)) {
                walk.sorted(Comparator.reverseOrder())
                        .map(Path::toFile)
                        .forEach(File::delete);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
