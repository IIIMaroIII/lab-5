3. convertPath
Method signature:
public static String convertPath(String path, boolean toWin)
===========================================================
Convert path to Unix\Windows path depending on a boolean parameter.
Unix path may start with ~ or /. Every subdirectory must end with / character except the last one. . and .. refer to current directory and parent directory. Filename doesn't necessarily have the extension.

===========================================================
Convert path to Unix\Windows path depending on a boolean parameter.
Unix path examples:
/folder/../folder/file.txt
/dev/null
file.txt
folder/logs/
~/user/some_logs
===========================================================
Convert path to Unix\Windows path depending on a boolean parameter.
Windows path may start with C:. Every subdirectory must end with \ character except the last one. Path elements . and .. refer to current directory and parent directory. Filename doesn't necessarily have the extension.
Windows path examples:
file.txt
\Program Files\some_file.exe
.\to_do_list.txt
C:Users\..\Cygwin\
.\file
===========================================================
Convert path to Unix\Windows path depending on a boolean parameter.
Let's consider Unix ~ path to correspond to Windows C:\User path and vice versa.
Let's consider Unix / root folder (i.e., when the path starts with /) to correspond to Windows C:\ drive and vice versa (but C:\User still corresponds to ~).
If path already corresponds to the required format (for instance, is Windows path when Windows paths is needed and toWin boolean parameter is true) return path.
If path is null, empty, or doesn't correspond to any path format (Unix, Windows), return null.
It is guaranteed that path is either a correct path, or it has some of the following errors:
===========================================================
Convert path to Unix\Windows path depending on a boolean parameter.
More than one ~
~ is not at the start
~ mixed with \ (~ in Windows path)
More than one C:
C: is not at the start
C: mixed with / (C: in Unix path)
\ mixed with /
===========================================================
Convert path to Unix\Windows path depending on a boolean parameter.
Illegal paths example:
/folder1/folder2\folder3
C:\User/root
/dev/~/
C:/a/b/c/d
~\folder
~/~
~~
C:\Folder\Subfolder\C:\
