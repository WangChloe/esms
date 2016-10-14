var gulp = require('gulp'),
  // $ = require('gulp-load-plugins')(),
  DIST_DIR = './dist';


gulp.task('clean', function() {
  return gulp.src([DIST_DIR + '/*'])
    .pipe($.rimraf({force: true}));
});

gulp.task('copy', function() {
  gulp.src(['images/*'])
    .pipe(gulp.dest(DIST_DIR + '/img/'));
  gulp.src(['fonts/*'])
    .pipe(gulp.dest(DIST_DIR + '/font/'));
});

gulp.task('jshint', function() {
  return gulp.src(['js/*.js'])
    .pipe($.jshint())
    // Use gulp-notify as jshint reporter
    .pipe($.notify(function(file) {
      if(file.jshint.success) {
        // Don't show something if success
        return false;
      }
      var errors = file.jshint.results.map(function(data) {
        if(data.error) {
          return "(" + data.error.line + ':' + data.error.character + ') ' + data.error.reason;
        }
      }).join("\n");
      return file.relative + " (" + file.jshint.results.length + " errors)\n" + errors;
    }))
    .pipe($.jshint.reporter('fail'));
});

gulp.task('templates', function() {
  return gulp.src(['*.html'])
    .pipe($.minifyHtml({empty: true, quotes: true, spare: true}))
    .pipe($.ngTemplate({
      moduleName: 'mainTemplates',
      standalone: true,
      //filePath: DIST_DIR + '/js/templates.js'
    }))
    .pipe(gulp.dest(DIST_DIR + '/js/'));
});
gulp.task('inject-less', function() {
  var injectFiles = gulp.src([
    'less/*.less'
  ], {read: false});

  var injectOptions = {
    transform: function(filePath) {
      filePath = filePath.replace('static/src/', '');
      return '@import "../' + filePath + '";';
    },
    starttag: '// inject:less',
    endtag: '// endinject',
    addRootSlash: false
  };

  return gulp.src(['less/style.less'])
    .pipe($.inject(injectFiles, injectOptions))
    .pipe($.concat('style-injected.less'))
    .pipe(gulp.dest('less/'));

});

gulp.task('css', ['inject-less'], function() {
  return gulp.src(['less/style-injected.less'])
    .pipe($.less().on('error', $.util.log))
    .pipe($.concat('app.css'))
    .pipe(gulp.dest(DIST_DIR + '/css/'));
});


gulp.task('csslib', function() {
  return gulp.src([
      // 'static/vendor/bootstrap/bootstrap.min.css',
      // 'static/vendor/zbfont/css/fontello.css',
      // 'static/vendor/zbfont/css/animation.css'
    ])
    .pipe($.concat('lib.css'))
    .pipe(gulp.dest(DIST_DIR + '/css/'));
});

gulp.task('jslib', function() {
  return gulp.src([
      // 'static/vendor/jquery/jquery.min.js',
    ])
    .pipe($.concat('lib.js'))
    .pipe(gulp.dest(DIST_DIR + '/js/'));
});


// dev 和 build 都会用到的任务
gulp.task('dev', ['clean', 'jshint', 'copy', 'css', 'csslib', 'jslib']);