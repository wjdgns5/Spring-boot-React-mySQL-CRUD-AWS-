import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { useSelector } from "react-redux";
import axiosInstance from "../api/axiosInstance";

function BoardListPage() {
  const [boards, setBoards] = useState([]);
  const [keyword, setKeyword] = useState("");
  const { isAuthenticated } = useSelector((state) => state.user);

  // --- join fetch 테스트용 ---------
  const [mode, setMode] = useState("fetch");
  // ---------------------------------

  useEffect(() => {
    getBoards();
  }, []);

  const getBoards = async () => {
    try {
      const res = await axiosInstance.get("/api/boards");
      setBoards(res.data);
    } catch (error) {
      console.error("게시글 목록 조회 실패:", error);
    }
  };

  const handleSearch = async () => {
    try {
      if (!keyword.trim()) {
        getBoards();
        return;
      }

      const res = await axiosInstance.get(
        `/api/boards/search?keyword=${keyword}`,
      );
      setBoards(res.data);
    } catch (error) {
      console.error("게시글 검색 실패:", error);
    }
  };

  // ------------- join fetch 테스트 -----------
  const getBoardsWithFetch = async () => {
    try {
      const res = await axiosInstance.get("/api/boards/test/fetch");
      setBoards(res.data);
      setMode("fetch");
    } catch (error) {
      console.error("fetch join 있음 조회 실패:", error);
    }
  };

  const getBoardsWithoutFetch = async () => {
    try {
      const res = await axiosInstance.get("/api/boards/test/no-fetch");
      setBoards(res.data);
      setMode("no-fetch");
    } catch (error) {
      console.error("fetch join 없음 조회 실패:", error);
    }
  };
  // ------------- -----------

  return (
    <div>
      <h2>게시글 목록</h2>

      <div style={{ marginBottom: "15px" }}>
        <input
          type="text"
          placeholder="제목, 내용, 작성자로 검색"
          value={keyword}
          onChange={(e) => setKeyword(e.target.value)}
        />
        <button onClick={handleSearch}>검색</button>
        <button onClick={getBoards}>전체보기</button>
      </div>

      {/* fetch-join test 버튼 */}
      <div style={{ marginBottom: "15px" }}>
        <button onClick={getBoardsWithoutFetch}>fetch join 없음</button>
        <button onClick={getBoardsWithFetch}>fetch join 있음</button>
      </div>

      {isAuthenticated && <Link to="/boards/write">글쓰기</Link>}

      {boards.length === 0 ? (
        <p>게시글이 없습니다.</p>
      ) : (
        <ul>
          {boards.map((board) => (
            <li key={board.id}>
              <Link to={`/boards/${board.id}`}>{board.title}</Link>
              {" - 작성자: "}
              {board.writer}
            </li>
          ))}
        </ul>
      )}
    </div>
  );
}

export default BoardListPage;
