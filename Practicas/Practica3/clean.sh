find . \( -name '*~' -o -name '#*#' \) -print0 | xargs --no-run-if-empty --null rm -vf
