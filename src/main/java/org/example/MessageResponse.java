package org.example;

public class MessageResponse {
    private int langId = 0;

    private Class resp = null;
    private Object respInstance = null;

    public void getLanguageSelection(String choice) {
        if (choice.equals("en")) {
            langId = 0;
        } else if (choice.equals("vi")) {
            langId = 1;
        } else {
            langId = 0;
        }

        if (langId == 0) {
            try {
                resp = Class.forName("org.example.MessageResponseEnglish");
                respInstance = resp.newInstance();
            } catch (Exception ex) {
                System.out.println(ex);
            }
        } else if (langId == 1) {
            try {
                resp = Class.forName("org.example.MessageResponseVietnamese");
                respInstance = resp.newInstance();
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }

    public String getGreeting() {
        if (respInstance != null && respInstance instanceof MessageResponseEnglish) {
            return ((MessageResponseVietnamese) respInstance).greeting;
        } else if (respInstance != null && respInstance instanceof MessageResponseVietnamese) {
            return ((MessageResponseVietnamese) respInstance).greeting;
        } else {
            return ((MessageResponseVietnamese) respInstance).greeting;
        }
    }

    public String getAttendanceOk() {
        if (respInstance != null && respInstance instanceof MessageResponseEnglish) {
            return ((MessageResponseEnglish) respInstance).attendance_ok;
        } else if (respInstance != null && respInstance instanceof MessageResponseVietnamese) {
            return ((MessageResponseVietnamese) respInstance).attendance_ok;
        } else {
            return ((MessageResponseEnglish) respInstance).attendance_ok;
        }
    }

    public String getAttendanceError() {
        if (respInstance != null && respInstance instanceof MessageResponseEnglish) {
            return ((MessageResponseEnglish) respInstance).attendance_error;
        } else if (respInstance != null && respInstance instanceof MessageResponseVietnamese) {
            return ((MessageResponseVietnamese) respInstance).attendance_error;
        } else {
            return ((MessageResponseEnglish) respInstance).attendance_error;
        }
    }

    public String getAttendanceBtnText() {
        if (respInstance != null && respInstance instanceof MessageResponseEnglish) {
            return ((MessageResponseEnglish) respInstance).attendance_btn;
        } else if (respInstance != null && respInstance instanceof MessageResponseVietnamese) {
            return ((MessageResponseVietnamese) respInstance).attendance_btn;
        } else {
            return ((MessageResponseEnglish) respInstance).attendance_btn;
        }
    }

    public String getHelp() {
        return MessageResponseEnglish.help_text;
    }

    public String getBotDoneMessage() {
        if (respInstance != null && respInstance instanceof MessageResponseEnglish) {
            return ((MessageResponseEnglish) respInstance).bot_done;
        } else if (respInstance != null && respInstance instanceof MessageResponseVietnamese) {
            return ((MessageResponseVietnamese) respInstance).bot_done;
        } else {
            return ((MessageResponseEnglish) respInstance).bot_done;
        }
    }
}
