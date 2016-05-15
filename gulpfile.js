var gulp = require('gulp');
var browserify = require('browserify');
var babelify = require('babelify');
var rename = require('gulp-rename');
var source = require('vinyl-source-stream');

// Basic usage
gulp.task('build', function() {
	var entryFile = 'src/main/resources/static/jsx/main.jsx';


  var bundler = browserify(entryFile, {extensions: [ ".js", ".jsx" ]});

  bundler.transform(babelify, {presets: ['es2015', 'react']});

//   bundler.add(entryFile);

  var stream = bundler.bundle();
  stream.on('error', function (err) { console.error(err.toString()) });

  stream
    .pipe(source(entryFile))
    .pipe(rename('index.js'))
    .pipe(gulp.dest('src/main/resources/static/js/'));
});

gulp.task('watch', function() {
  gulp.watch(['src/main/resources/static/jsx/**/*'], ['scripts']);
});
