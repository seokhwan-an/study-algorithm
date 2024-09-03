import java.util.*;

class Solution {
    
    class FileInfo {
        int index;
        String head;
        String number;
        String tail;
        
        public FileInfo(int index, String head, String number, String tail) {
            this.index = index;
            this.head = head;
            this.number = number;
            this.tail = tail;
        }
        
        public String makeFile() {
            return head + number + tail;
        }
        
        public int compareTo(FileInfo other) {
            String thisHead = head.toLowerCase();
            String otherHead = other.head.toLowerCase();
            if (thisHead.compareTo(otherHead) < 0) {
                return -1;
            } else if (thisHead.compareTo(otherHead) > 0) {
                return 1;
            } else {
                Integer thisNumber = Integer.parseInt(number);
                Integer otherNumber = Integer.parseInt(other.number);
                if (thisNumber.compareTo(otherNumber) < 0) {
                    return -1;
                } else if (thisNumber.compareTo(otherNumber) > 0) {
                    return 1;
                } else {
                    if (index < other.index) {
                        return -1;
                    }
                }
            }
            return 1;
        }
    }
    
    public String[] solution(String[] files) {
        String[] answer = {};
        List<FileInfo> fileInfos = new ArrayList<>();
        
        // file을 fileInfos로 변경
        int index = 0;
        for (String file : files) {
            FileInfo fileInfo = changeToFileInfo(file, index);
            fileInfos.add(fileInfo);
            index++;
        }
        
        fileInfos.sort((f1, f2) -> f1.compareTo(f2));
        
        return changeToArray(fileInfos);
    }
    
    private FileInfo changeToFileInfo(String file, int index) {
        int headIndex = 0;
        char[] chars = file.toCharArray();
        
        // head 찾기
        for (char c : chars) {
            if ('0' <= c && c <= '9') {
                break;
            }
            headIndex++;
        }
        String head = file.substring(0, headIndex);
        
        // number 찾기
        int numberIndex = headIndex;
        for (int i = numberIndex; i < chars.length; i++) {
            char c = chars[i];
            if (!('0' <= c && c <= '9')) {
                break;
            } 
            numberIndex++;
        }
        String number = file.substring(headIndex, numberIndex);
        String tail = file.substring(numberIndex);
        
        return new FileInfo(index, head, number, tail);
    }
    
    private String[] changeToArray(List<FileInfo> fileInfos) {
        String[] answer = new String[fileInfos.size()];
        
        int index = 0;
        for (FileInfo fileInfo : fileInfos) {
            answer[index++] = fileInfo.makeFile();
        }
        
        return answer;
    }

}