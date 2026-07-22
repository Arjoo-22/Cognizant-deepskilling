import BookDetails from "./Components/BookDetails";
import BlogDetails from "./Components/BlogDetails";
import CourseDetails from "./Components/CourseDetails";

import { books, blogs, courses } from "./Data/Data";

function App() {

  const show = true;

  return (

    <div
      style={{
        display: "flex",
        justifyContent: "space-around",
        marginTop: "40px"
      }}
    >

      {show && <CourseDetails courses={courses} />}

      {show ? <BookDetails books={books} /> : null}

      <BlogDetails blogs={blogs} />

    </div>

  );

}

export default App;